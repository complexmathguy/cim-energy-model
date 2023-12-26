import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService'

class ViewGovSteamEUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamEU: {}
        }
    }

    componentDidMount(){
        GovSteamEUService.getGovSteamEUById(this.state.id).then( res => {
            this.setState({govSteamEU: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamEU Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> chc:&emsp; </label>
                            <div> { this.state.govSteamEU.chc }</div>
                        </div>
                        <div className = "row">
                            <label> cho:&emsp; </label>
                            <div> { this.state.govSteamEU.cho }</div>
                        </div>
                        <div className = "row">
                            <label> cic:&emsp; </label>
                            <div> { this.state.govSteamEU.cic }</div>
                        </div>
                        <div className = "row">
                            <label> cio:&emsp; </label>
                            <div> { this.state.govSteamEU.cio }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govSteamEU.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govSteamEU.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> hhpmax:&emsp; </label>
                            <div> { this.state.govSteamEU.hhpmax }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.govSteamEU.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kfcor:&emsp; </label>
                            <div> { this.state.govSteamEU.kfcor }</div>
                        </div>
                        <div className = "row">
                            <label> khp:&emsp; </label>
                            <div> { this.state.govSteamEU.khp }</div>
                        </div>
                        <div className = "row">
                            <label> klp:&emsp; </label>
                            <div> { this.state.govSteamEU.klp }</div>
                        </div>
                        <div className = "row">
                            <label> kwcor:&emsp; </label>
                            <div> { this.state.govSteamEU.kwcor }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteamEU.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govSteamEU.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> prhmax:&emsp; </label>
                            <div> { this.state.govSteamEU.prhmax }</div>
                        </div>
                        <div className = "row">
                            <label> simx:&emsp; </label>
                            <div> { this.state.govSteamEU.simx }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govSteamEU.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tdp:&emsp; </label>
                            <div> { this.state.govSteamEU.tdp }</div>
                        </div>
                        <div className = "row">
                            <label> ten:&emsp; </label>
                            <div> { this.state.govSteamEU.ten }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.govSteamEU.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tfp:&emsp; </label>
                            <div> { this.state.govSteamEU.tfp }</div>
                        </div>
                        <div className = "row">
                            <label> thp:&emsp; </label>
                            <div> { this.state.govSteamEU.thp }</div>
                        </div>
                        <div className = "row">
                            <label> tip:&emsp; </label>
                            <div> { this.state.govSteamEU.tip }</div>
                        </div>
                        <div className = "row">
                            <label> tlp:&emsp; </label>
                            <div> { this.state.govSteamEU.tlp }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govSteamEU.tp }</div>
                        </div>
                        <div className = "row">
                            <label> trh:&emsp; </label>
                            <div> { this.state.govSteamEU.trh }</div>
                        </div>
                        <div className = "row">
                            <label> tvhp:&emsp; </label>
                            <div> { this.state.govSteamEU.tvhp }</div>
                        </div>
                        <div className = "row">
                            <label> tvip:&emsp; </label>
                            <div> { this.state.govSteamEU.tvip }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govSteamEU.tw }</div>
                        </div>
                        <div className = "row">
                            <label> wfmax:&emsp; </label>
                            <div> { this.state.govSteamEU.wfmax }</div>
                        </div>
                        <div className = "row">
                            <label> wfmin:&emsp; </label>
                            <div> { this.state.govSteamEU.wfmin }</div>
                        </div>
                        <div className = "row">
                            <label> wmax1:&emsp; </label>
                            <div> { this.state.govSteamEU.wmax1 }</div>
                        </div>
                        <div className = "row">
                            <label> wmax2:&emsp; </label>
                            <div> { this.state.govSteamEU.wmax2 }</div>
                        </div>
                        <div className = "row">
                            <label> wwmax:&emsp; </label>
                            <div> { this.state.govSteamEU.wwmax }</div>
                        </div>
                        <div className = "row">
                            <label> wwmin:&emsp; </label>
                            <div> { this.state.govSteamEU.wwmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamEUComponent
