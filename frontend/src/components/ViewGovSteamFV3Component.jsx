import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service'

class ViewGovSteamFV3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV3: {}
        }
    }

    componentDidMount(){
        GovSteamFV3Service.getGovSteamFV3ById(this.state.id).then( res => {
            this.setState({govSteamFV3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV3 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govSteamFV3.k }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.govSteamFV3.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.govSteamFV3.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.govSteamFV3.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteamFV3.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govSteamFV3.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govSteamFV3.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> prmax:&emsp; </label>
                            <div> { this.state.govSteamFV3.prmax }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteamFV3.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govSteamFV3.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govSteamFV3.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govSteamFV3.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govSteamFV3.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.govSteamFV3.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govSteamFV3.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govSteamFV3.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govSteamFV3.tc }</div>
                        </div>
                        <div className = "row">
                            <label> uc:&emsp; </label>
                            <div> { this.state.govSteamFV3.uc }</div>
                        </div>
                        <div className = "row">
                            <label> uo:&emsp; </label>
                            <div> { this.state.govSteamFV3.uo }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV3Component
