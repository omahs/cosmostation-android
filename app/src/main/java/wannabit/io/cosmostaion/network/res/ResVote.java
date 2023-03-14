package wannabit.io.cosmostaion.network.res;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResVote {
    @SerializedName("id")
    public int id;

    @SerializedName("tx_hash")
    public String tx_hash;

    @SerializedName("proposer")
    public String proposer;

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("proposal_type")
    public String proposal_type;

    @SerializedName("proposal_status")
    public String proposal_status;

    @SerializedName("submit_time")
    public String submit_time;

    @SerializedName("voting_start_time")
    public String voting_start_time;

    @SerializedName("voting_end_time")
    public String voting_end_time;

    @SerializedName("messages")
    public List<Messages> messages;

    @SerializedName("moniker")
    public String moniker;

    @SerializedName("voteMeta")
    public VoteMeta voteMeta;

    public class Messages {
        @SerializedName("@type")
        public String type;

        @SerializedName("title")
        public String title;

        @SerializedName("description")
        public String description;

        @SerializedName("recipient")
        public String recipient;

    }

    public class VoteMeta {
        @SerializedName("yes")
        public String yes;

        @SerializedName("no")
        public String no;

        @SerializedName("no_with_veto")
        public String no_with_veto;

        @SerializedName("abstain")
        public String abstain;

        @SerializedName("yes_amount")
        public String yes_amount;

        @SerializedName("no_amount")
        public String no_amount;

        @SerializedName("no_with_veto_amount")
        public String no_with_veto_amount;

        @SerializedName("abstain_amount")
        public String abstain_amount;
    }
}