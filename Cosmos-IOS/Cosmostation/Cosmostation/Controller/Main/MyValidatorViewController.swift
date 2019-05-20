//
//  MyValidatorViewController.swift
//  Cosmostation
//
//  Created by yongjoo on 22/03/2019.
//  Copyright © 2019 wannabit. All rights reserved.
//

import UIKit
import Alamofire
import AlamofireImage

class MyValidatorViewController: BaseViewController, UITableViewDelegate, UITableViewDataSource, ClaimRewardAllDelegate {
    
    
    @IBOutlet weak var myValidatorTableView: UITableView!
    
    var mainTabVC: MainTabViewController!
    var refresher: UIRefreshControl!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.myValidatorTableView.delegate = self
        self.myValidatorTableView.dataSource = self
        self.myValidatorTableView.separatorStyle = UITableViewCell.SeparatorStyle.none
        self.myValidatorTableView.register(UINib(nibName: "MyValidatorCell", bundle: nil), forCellReuseIdentifier: "MyValidatorCell")
        self.myValidatorTableView.register(UINib(nibName: "ClaimRewardAllCell", bundle: nil), forCellReuseIdentifier: "ClaimRewardAllCell")
        self.myValidatorTableView.register(UINib(nibName: "PromotionCell", bundle: nil), forCellReuseIdentifier: "PromotionCell")

        self.refresher = UIRefreshControl()
        self.refresher.addTarget(self, action: #selector(onRequestFetch), for: .valueChanged)
        self.refresher.tintColor = UIColor.white
        self.myValidatorTableView.addSubview(refresher)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.mainTabVC = ((self.parent)?.parent)?.parent as? MainTabViewController
        self.onSortingMy()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        NotificationCenter.default.addObserver(self, selector: #selector(self.onFetchDone(_:)), name: Notification.Name("onFetchDone"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.onSortingMy), name: Notification.Name("onSortingMy"), object: nil)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        NotificationCenter.default.removeObserver(self, name: Notification.Name("onFetchDone"), object: nil)
        NotificationCenter.default.removeObserver(self, name: Notification.Name("onSortingMy"), object: nil)
    }
    
    @objc func onFetchDone(_ notification: NSNotification) {
        self.onSortingMy()
        self.refresher.endRefreshing()
    }
    
    @objc func onSortingMy() {
        if (BaseData.instance.getMyValidatorSort() == 0) {
            sortByDelegated()
        } else if (BaseData.instance.getMyValidatorSort() == 1) {
            sortByName()
        } else {
            sortByReward()
        }
        self.myValidatorTableView.reloadData()
    }
    
    @objc func onRequestFetch() {
        if(!mainTabVC.onFetchAccountData()) {
            self.refresher.endRefreshing()
        }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if (self.mainTabVC.mMyValidators.count < 1) {
            return 1;
        } else if (self.mainTabVC.mMyValidators.count == 1) {
            return 1;
        } else {
            return self.mainTabVC.mMyValidators.count  + 1;
        }
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if (mainTabVC.mMyValidators.count < 1) {
            let cell:PromotionCell? = tableView.dequeueReusableCell(withIdentifier:"PromotionCell") as? PromotionCell
            return cell!
            
        } else if (mainTabVC.mMyValidators.count == 1) {
            let cell:MyValidatorCell? = tableView.dequeueReusableCell(withIdentifier:"MyValidatorCell") as? MyValidatorCell
            let validator = mainTabVC.mMyValidators[indexPath.row]
            self.onSetValidatorItem(cell!, validator, indexPath)
            return cell!
            
        } else {
            if (indexPath.row == mainTabVC.mMyValidators.count) {
                let cell:ClaimRewardAllCell? = tableView.dequeueReusableCell(withIdentifier:"ClaimRewardAllCell") as? ClaimRewardAllCell
                self.onSetClaimAllItem(cell!)
                return cell!
            } else {
                let cell:MyValidatorCell? = tableView.dequeueReusableCell(withIdentifier:"MyValidatorCell") as? MyValidatorCell
                let validator = mainTabVC.mMyValidators[indexPath.row]
                self.onSetValidatorItem(cell!, validator, indexPath)
                return cell!
            }
        }
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        if (mainTabVC.mMyValidators.count < 1) {
            return 168;
        } else {
            if (indexPath.row == mainTabVC.mMyValidators.count) {
                return 70;
            } else {
                return 80;
            }
            
        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if (mainTabVC.mMyValidators.count > 0 && indexPath.row != mainTabVC.mMyValidators.count) {
            if let validator = self.mainTabVC.mMyValidators[indexPath.row] as? Validator {
                let validatorDetailVC = UIStoryboard(name: "MainStoryboard", bundle: nil).instantiateViewController(withIdentifier: "VaidatorDetailViewController") as! VaidatorDetailViewController
                validatorDetailVC.mValidator = validator
                validatorDetailVC.hidesBottomBarWhenPushed = true
                self.navigationItem.title = ""
                self.navigationController?.pushViewController(validatorDetailVC, animated: true)
            }
        }
    }
    
    
    func onSetValidatorItem(_ cell: MyValidatorCell, _ validator: Validator, _ indexPath: IndexPath) {
        cell.monikerLabel.text = validator.description.moniker
        
        if(validator.jailed) { cell.revokedImg.isHidden = false
        } else { cell.revokedImg.isHidden = true }
        
        cell.freeEventImg.isHidden = true
        
        let bonding = BaseData.instance.selectBondingWithValAdd(mainTabVC.mAccount.account_id, validator.operator_address)
        
        
//        print("bonding ", bonding!.getBondingAtom(validator))
        if(bonding != nil) {
            cell.myDelegatedAmoutLabel.attributedText = WUtils.displayAmout(bonding!.getBondingAtom(validator).stringValue, cell.myDelegatedAmoutLabel.font, 6)
        } else {
            cell.myDelegatedAmoutLabel.attributedText = WUtils.displayAmout("0", cell.myDelegatedAmoutLabel.font, 6)
        }
        
        cell.rewardAmoutLabel.attributedText = WUtils.displayAmout(WUtils.getValidatorReward(mainTabVC.mRewardList, validator.operator_address).stringValue, cell.rewardAmoutLabel.font, 6)
        
        cell.validatorImg.tag = indexPath.row
        cell.validatorImg.image = UIImage.init(named: "validatorNoneImg")
        if (validator.description.identity != "") {
            let parameters: Parameters = ["fields": "pictures", "key_suffix": validator.description.identity]
            let request = Alamofire.request(KEY_BASE_URL_USER_INFO,
                                            method: .get,
                                            parameters: parameters,
                                            encoding: URLEncoding.default,
                                            headers: [:]);
            request.responseJSON { (response) in
                switch response.result {
                case .success(let res):
                    guard let keybaseInfo = res as? NSDictionary,
                        let thems = keybaseInfo.value(forKey: "them") as? Array<NSDictionary>,
                        let url = thems[0].value(forKeyPath: "pictures.primary.url") as? String else {
                        return
                    }
                    
                    Alamofire.request(url, method: .get).responseImage { response  in
                        guard let image = response.result.value else {
                            return
                        }
                        if(indexPath.row == cell.validatorImg.tag) {
                            cell.validatorImg.image = image
                        }
                    }
                
                case .failure(let error):
                    print("onSetValidatorItem error : ", error)
                }
            }
        }
    }
    
    func onSetClaimAllItem(_ cell: ClaimRewardAllCell) {
        if let allReward = self.mainTabVC.mAllRewards[0].amount as? String {
            cell.totalRewardLabel.attributedText = WUtils.displayAmout(allReward, cell.totalRewardLabel.font, 6)
        } else {
            cell.totalRewardLabel.attributedText = WUtils.displayAmout("0", cell.totalRewardLabel.font, 6)
        }
        cell.delegate = self
    }
    
    
    func didTapClaimAll(_ sender: UIButton) {
        print("didTapClaimAll ",  self.mainTabVC.mAllRewards[0].amount)
        if(!self.mainTabVC.mAccount.account_has_private) {
            self.onShowAddMenomicDialog()
        }
        
        if(WUtils.stringToDecimal(self.mainTabVC.mAllRewards[0].amount).rounding(accordingToBehavior: WUtils.handler0).compare(NSDecimalNumber.zero).rawValue <= 0) {
            self.onShowToast(NSLocalizedString("error_not_reward", comment: ""))
            return
        }
        
        
        var myBondedValidator = Array<Validator>()
        var toClaimValidator = Array<Validator>()
        
        for validator in self.mainTabVC.mTopValidators {
            for bonding in self.mainTabVC.mBondingList {
                if(bonding.bonding_v_address == validator.operator_address &&
                    WUtils.getValidatorReward(mainTabVC.mRewardList, bonding.bonding_v_address).compare(NSDecimalNumber(string: "1")).rawValue > 0) {
                    myBondedValidator.append(validator)
                    break;
                }
            }
        }
        
//        print("myBondedValidator ", myBondedValidator.count)
        
        myBondedValidator.sort{
            let reward0 = WUtils.getValidatorReward(mainTabVC.mRewardList, $0.operator_address)
            let reward1 = WUtils.getValidatorReward(mainTabVC.mRewardList, $1.operator_address)
            return reward0.compare(reward1).rawValue > 0 ? true : false
        }
        
        if(myBondedValidator.count > 16) {
            toClaimValidator = Array(myBondedValidator[0..<16])
        } else {
            toClaimValidator = myBondedValidator
        }
        
//        print("toClaimValidator ", toClaimValidator.count)
        
        let mintFee = WUtils.getGasAmountForRewards()[toClaimValidator.count-1].multiplying(by: WUtils.stringToDecimal(FEE_MIN_RATE))
//        print("mintFee ", mintFee)
        
        var available = NSDecimalNumber.zero
        for balance in self.mainTabVC.mBalances {
            if(TESTNET) {
                if(balance.balance_denom == "muon") {
                    available = available.adding(WUtils.stringToDecimal(balance.balance_amount))
                }
            } else {
                if(balance.balance_denom == "uatom") {
                    available = available.adding(WUtils.stringToDecimal(balance.balance_amount))
                }
            }
        }
//        print("available ", available)
        if(available.compare(mintFee).rawValue < 0 ) {
            self.onShowToast(NSLocalizedString("error_not_enough_fee", comment: ""))
            return
        }
        
        if(WUtils.stringToDecimal(self.mainTabVC.mAllRewards[0].amount).rounding(accordingToBehavior: WUtils.handler0).compare(mintFee).rawValue <= 0) {
            self.onShowToast(NSLocalizedString("error_wasting_fee", comment: ""))
            return
        }
        
        let stakingVC = UIStoryboard(name: "GenTx", bundle: nil).instantiateViewController(withIdentifier: "StakingViewController") as! StakingViewController
        stakingVC.mRewardTargetValidators = toClaimValidator
        stakingVC.mType = COSMOS_MSG_TYPE_WITHDRAW_DEL
        stakingVC.hidesBottomBarWhenPushed = true
        self.navigationItem.title = ""
        self.navigationController?.pushViewController(stakingVC, animated: true)
    }
    
    
    func sortByName() {
        mainTabVC.mMyValidators.sort{
            if ($0.jailed && !$1.jailed) {
                return false
            }
            if (!$0.jailed && $1.jailed) {
                return true
            }
            return $0.description.moniker < $1.description.moniker
        }
    }
    
    func sortByDelegated() {
        mainTabVC.mMyValidators.sort{
            if ($0.jailed && !$1.jailed) {
                return false
            }
            if (!$0.jailed && $1.jailed) {
                return true
            }
            var bonding0:Double = 0
            var bonding1:Double = 0
            if(BaseData.instance.selectBondingWithValAdd(mainTabVC.mAccount.account_id, $0.operator_address) != nil) {
                bonding0 = Double(BaseData.instance.selectBondingWithValAdd(mainTabVC.mAccount.account_id, $0.operator_address)!.getBondingAtom($0)) as! Double
            }
            if(BaseData.instance.selectBondingWithValAdd(mainTabVC.mAccount.account_id, $1.operator_address) != nil) {
                bonding1 = Double(BaseData.instance.selectBondingWithValAdd(mainTabVC.mAccount.account_id, $1.operator_address)!.getBondingAtom($1)) as! Double
            }
            return bonding0 > bonding1
        }
    }
    
    func sortByReward() {
        mainTabVC.mMyValidators.sort{
            if ($0.jailed && !$1.jailed) {
                return false
            }
            if (!$0.jailed && $1.jailed) {
                return true
            }
            
            let reward0 = WUtils.getValidatorReward(mainTabVC.mRewardList, $0.operator_address)
            let reward1 = WUtils.getValidatorReward(mainTabVC.mRewardList, $1.operator_address)
            return reward0.compare(reward1).rawValue > 0 ? true : false
        }
    }
    
    
    
    
    func onShowAddMenomicDialog() {
        let alert = UIAlertController(title: NSLocalizedString("alert_title_no_private_key", comment: ""), message: NSLocalizedString("alert_msg_no_private_key", comment: ""), preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: NSLocalizedString("add_mnemonic", comment: ""), style: .default, handler: { [weak alert] (_) in
            self.onStartImportMnemonic()
        }))
        alert.addAction(UIAlertAction(title: NSLocalizedString("cancel", comment: ""), style: .cancel, handler: nil))
        self.present(alert, animated: true, completion: nil)
    }
}
