package wannabit.io.cosmostaion.network.req.neutron

data class GetConfigReq(val get_config: GetConfig)
class GetConfig

data class ConfigReq(val config: Config)
class Config

data class TotalPowerReq(val total_power_at_height: TotalPower)
class TotalPower

data class VotingPowerReq(val voting_power_at_height: VotingPower)
data class VotingPower(val address: String)

data class ProposalListReq(val reverse_proposals: ProposalList)
class ProposalList

data class ProposalDataReq(val proposal: Proposal)
data class Proposal(val proposal_id: Int)