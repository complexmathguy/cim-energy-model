import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service'

class ViewGovSteam2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam2: {}
        }
    }

    componentDidMount(){
        GovSteam2Service.getGovSteam2ById(this.state.id).then( res => {
            this.setState({govSteam2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dbf:&emsp; </label>
                            <div> { this.state.govSteam2.dbf }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govSteam2.k }</div>
                        </div>
                        <div className = "row">
                            <label> mnef:&emsp; </label>
                            <div> { this.state.govSteam2.mnef }</div>
                        </div>
                        <div className = "row">
                            <label> mxef:&emsp; </label>
                            <div> { this.state.govSteam2.mxef }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govSteam2.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govSteam2.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteam2.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govSteam2.t2 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam2Component
