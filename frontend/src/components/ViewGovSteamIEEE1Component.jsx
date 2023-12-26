import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service'

class ViewGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamIEEE1: {}
        }
    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1ById(this.state.id).then( res => {
            this.setState({govSteamIEEE1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamIEEE1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> k5:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k5 }</div>
                        </div>
                        <div className = "row">
                            <label> k6:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k6 }</div>
                        </div>
                        <div className = "row">
                            <label> k7:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k7 }</div>
                        </div>
                        <div className = "row">
                            <label> k8:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.k8 }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> uc:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.uc }</div>
                        </div>
                        <div className = "row">
                            <label> uo:&emsp; </label>
                            <div> { this.state.govSteamIEEE1.uo }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamIEEE1Component
