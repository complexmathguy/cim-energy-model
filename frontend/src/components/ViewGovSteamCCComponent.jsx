import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService'

class ViewGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamCC: {}
        }
    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCById(this.state.id).then( res => {
            this.setState({govSteamCC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamCC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dhp:&emsp; </label>
                            <div> { this.state.govSteamCC.dhp }</div>
                        </div>
                        <div className = "row">
                            <label> dlp:&emsp; </label>
                            <div> { this.state.govSteamCC.dlp }</div>
                        </div>
                        <div className = "row">
                            <label> fhp:&emsp; </label>
                            <div> { this.state.govSteamCC.fhp }</div>
                        </div>
                        <div className = "row">
                            <label> flp:&emsp; </label>
                            <div> { this.state.govSteamCC.flp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteamCC.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmaxhp:&emsp; </label>
                            <div> { this.state.govSteamCC.pmaxhp }</div>
                        </div>
                        <div className = "row">
                            <label> pmaxlp:&emsp; </label>
                            <div> { this.state.govSteamCC.pmaxlp }</div>
                        </div>
                        <div className = "row">
                            <label> rhp:&emsp; </label>
                            <div> { this.state.govSteamCC.rhp }</div>
                        </div>
                        <div className = "row">
                            <label> rlp:&emsp; </label>
                            <div> { this.state.govSteamCC.rlp }</div>
                        </div>
                        <div className = "row">
                            <label> t1hp:&emsp; </label>
                            <div> { this.state.govSteamCC.t1hp }</div>
                        </div>
                        <div className = "row">
                            <label> t1lp:&emsp; </label>
                            <div> { this.state.govSteamCC.t1lp }</div>
                        </div>
                        <div className = "row">
                            <label> t3hp:&emsp; </label>
                            <div> { this.state.govSteamCC.t3hp }</div>
                        </div>
                        <div className = "row">
                            <label> t3lp:&emsp; </label>
                            <div> { this.state.govSteamCC.t3lp }</div>
                        </div>
                        <div className = "row">
                            <label> t4hp:&emsp; </label>
                            <div> { this.state.govSteamCC.t4hp }</div>
                        </div>
                        <div className = "row">
                            <label> t4lp:&emsp; </label>
                            <div> { this.state.govSteamCC.t4lp }</div>
                        </div>
                        <div className = "row">
                            <label> t5hp:&emsp; </label>
                            <div> { this.state.govSteamCC.t5hp }</div>
                        </div>
                        <div className = "row">
                            <label> t5lp:&emsp; </label>
                            <div> { this.state.govSteamCC.t5lp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamCCComponent
