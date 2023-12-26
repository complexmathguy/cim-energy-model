import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service'

class ViewGovSteam0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam0: {}
        }
    }

    componentDidMount(){
        GovSteam0Service.getGovSteam0ById(this.state.id).then( res => {
            this.setState({govSteam0: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam0 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dt:&emsp; </label>
                            <div> { this.state.govSteam0.dt }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteam0.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govSteam0.r }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteam0.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govSteam0.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govSteam0.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govSteam0.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govSteam0.vmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam0Component
