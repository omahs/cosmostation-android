//
//  JoinPool3ViewController.swift
//  Cosmostation
//
//  Created by 정용주 on 2021/07/19.
//  Copyright © 2021 wannabit. All rights reserved.
//

import UIKit
import HDWalletKit
import SwiftKeychainWrapper
import GRPC
import NIO

class JoinPool3ViewController: BaseViewController {
    
    @IBOutlet weak var txFeeAmountLabel: UILabel!
    @IBOutlet weak var txFeeDenomLabel: UILabel!
    @IBOutlet weak var deposit0AmountLabel: UILabel!
    @IBOutlet weak var deposit0DenomLabel: UILabel!
    @IBOutlet weak var deposit1AmountLabel: UILabel!
    @IBOutlet weak var deposit1DenomLabel: UILabel!
    @IBOutlet weak var lpAmountLabel: UILabel!
    @IBOutlet weak var lpDenomLabel: UILabel!
    @IBOutlet weak var memoLabel: UILabel!
    @IBOutlet weak var btnBack: UIButton!
    @IBOutlet weak var btnConfirm: UIButton!

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    

    
    
    @IBAction func onClickBack(_ sender: UIButton) {
    }
    
    @IBAction func onClickConfirm(_ sender: UIButton) {
    }
    
}
