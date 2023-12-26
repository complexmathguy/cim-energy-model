import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service'

class ViewGovSteamFV2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV2: {}
        }
    }

    componentDidMount(){
        GovSteamFV2Service.getGovSteamFV2ById(this.state.id).then( res => {
            this.setState({govSteamFV2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dt:&emsp; </label>
                            <div> { this.state.govSteamFV2.dt }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govSteamFV2.k }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteamFV2.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govSteamFV2.r }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteamFV2.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govSteamFV2.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govSteamFV2.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govSteamFV2.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govSteamFV2.tc }</div>
                        </div>
                        <div className = "row">
                            <label> ti:&emsp; </label>
                            <div> { this.state.govSteamFV2.ti }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govSteamFV2.tt }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govSteamFV2.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govSteamFV2.vmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV2Component
