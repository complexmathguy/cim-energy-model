import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service'

class ViewGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV4: {}
        }
    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4ById(this.state.id).then( res => {
            this.setState({govSteamFV4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV4 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> cpsmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.cpsmn }</div>
                        </div>
                        <div className = "row">
                            <label> cpsmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.cpsmx }</div>
                        </div>
                        <div className = "row">
                            <label> crmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.crmn }</div>
                        </div>
                        <div className = "row">
                            <label> crmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.crmx }</div>
                        </div>
                        <div className = "row">
                            <label> kdc:&emsp; </label>
                            <div> { this.state.govSteamFV4.kdc }</div>
                        </div>
                        <div className = "row">
                            <label> kf1:&emsp; </label>
                            <div> { this.state.govSteamFV4.kf1 }</div>
                        </div>
                        <div className = "row">
                            <label> kf3:&emsp; </label>
                            <div> { this.state.govSteamFV4.kf3 }</div>
                        </div>
                        <div className = "row">
                            <label> khp:&emsp; </label>
                            <div> { this.state.govSteamFV4.khp }</div>
                        </div>
                        <div className = "row">
                            <label> kic:&emsp; </label>
                            <div> { this.state.govSteamFV4.kic }</div>
                        </div>
                        <div className = "row">
                            <label> kip:&emsp; </label>
                            <div> { this.state.govSteamFV4.kip }</div>
                        </div>
                        <div className = "row">
                            <label> kit:&emsp; </label>
                            <div> { this.state.govSteamFV4.kit }</div>
                        </div>
                        <div className = "row">
                            <label> kmp1:&emsp; </label>
                            <div> { this.state.govSteamFV4.kmp1 }</div>
                        </div>
                        <div className = "row">
                            <label> kmp2:&emsp; </label>
                            <div> { this.state.govSteamFV4.kmp2 }</div>
                        </div>
                        <div className = "row">
                            <label> kpc:&emsp; </label>
                            <div> { this.state.govSteamFV4.kpc }</div>
                        </div>
                        <div className = "row">
                            <label> kpp:&emsp; </label>
                            <div> { this.state.govSteamFV4.kpp }</div>
                        </div>
                        <div className = "row">
                            <label> kpt:&emsp; </label>
                            <div> { this.state.govSteamFV4.kpt }</div>
                        </div>
                        <div className = "row">
                            <label> krc:&emsp; </label>
                            <div> { this.state.govSteamFV4.krc }</div>
                        </div>
                        <div className = "row">
                            <label> ksh:&emsp; </label>
                            <div> { this.state.govSteamFV4.ksh }</div>
                        </div>
                        <div className = "row">
                            <label> lpi:&emsp; </label>
                            <div> { this.state.govSteamFV4.lpi }</div>
                        </div>
                        <div className = "row">
                            <label> lps:&emsp; </label>
                            <div> { this.state.govSteamFV4.lps }</div>
                        </div>
                        <div className = "row">
                            <label> mnef:&emsp; </label>
                            <div> { this.state.govSteamFV4.mnef }</div>
                        </div>
                        <div className = "row">
                            <label> mxef:&emsp; </label>
                            <div> { this.state.govSteamFV4.mxef }</div>
                        </div>
                        <div className = "row">
                            <label> pr1:&emsp; </label>
                            <div> { this.state.govSteamFV4.pr1 }</div>
                        </div>
                        <div className = "row">
                            <label> pr2:&emsp; </label>
                            <div> { this.state.govSteamFV4.pr2 }</div>
                        </div>
                        <div className = "row">
                            <label> psmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.psmn }</div>
                        </div>
                        <div className = "row">
                            <label> rsmimn:&emsp; </label>
                            <div> { this.state.govSteamFV4.rsmimn }</div>
                        </div>
                        <div className = "row">
                            <label> rsmimx:&emsp; </label>
                            <div> { this.state.govSteamFV4.rsmimx }</div>
                        </div>
                        <div className = "row">
                            <label> rvgmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.rvgmn }</div>
                        </div>
                        <div className = "row">
                            <label> rvgmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.rvgmx }</div>
                        </div>
                        <div className = "row">
                            <label> srmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.srmn }</div>
                        </div>
                        <div className = "row">
                            <label> srmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.srmx }</div>
                        </div>
                        <div className = "row">
                            <label> srsmp:&emsp; </label>
                            <div> { this.state.govSteamFV4.srsmp }</div>
                        </div>
                        <div className = "row">
                            <label> svmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.svmn }</div>
                        </div>
                        <div className = "row">
                            <label> svmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.svmx }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govSteamFV4.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tam:&emsp; </label>
                            <div> { this.state.govSteamFV4.tam }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govSteamFV4.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tcm:&emsp; </label>
                            <div> { this.state.govSteamFV4.tcm }</div>
                        </div>
                        <div className = "row">
                            <label> tdc:&emsp; </label>
                            <div> { this.state.govSteamFV4.tdc }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.govSteamFV4.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.govSteamFV4.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> thp:&emsp; </label>
                            <div> { this.state.govSteamFV4.thp }</div>
                        </div>
                        <div className = "row">
                            <label> tmp:&emsp; </label>
                            <div> { this.state.govSteamFV4.tmp }</div>
                        </div>
                        <div className = "row">
                            <label> trh:&emsp; </label>
                            <div> { this.state.govSteamFV4.trh }</div>
                        </div>
                        <div className = "row">
                            <label> tv:&emsp; </label>
                            <div> { this.state.govSteamFV4.tv }</div>
                        </div>
                        <div className = "row">
                            <label> ty:&emsp; </label>
                            <div> { this.state.govSteamFV4.ty }</div>
                        </div>
                        <div className = "row">
                            <label> y:&emsp; </label>
                            <div> { this.state.govSteamFV4.y }</div>
                        </div>
                        <div className = "row">
                            <label> yhpmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.yhpmn }</div>
                        </div>
                        <div className = "row">
                            <label> yhpmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.yhpmx }</div>
                        </div>
                        <div className = "row">
                            <label> ympmn:&emsp; </label>
                            <div> { this.state.govSteamFV4.ympmn }</div>
                        </div>
                        <div className = "row">
                            <label> ympmx:&emsp; </label>
                            <div> { this.state.govSteamFV4.ympmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV4Component
