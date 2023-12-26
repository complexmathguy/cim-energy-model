import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService'

class ViewGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroWPID: {}
        }
    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDById(this.state.id).then( res => {
            this.setState({govHydroWPID: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroWPID Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> d:&emsp; </label>
                            <div> { this.state.govHydroWPID.d }</div>
                        </div>
                        <div className = "row">
                            <label> gatmax:&emsp; </label>
                            <div> { this.state.govHydroWPID.gatmax }</div>
                        </div>
                        <div className = "row">
                            <label> gatmin:&emsp; </label>
                            <div> { this.state.govHydroWPID.gatmin }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydroWPID.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydroWPID.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydroWPID.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.govHydroWPID.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govHydroWPID.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.govHydroWPID.kp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroWPID.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govHydroWPID.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govHydroWPID.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govHydroWPID.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govHydroWPID.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govHydroWPID.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> reg:&emsp; </label>
                            <div> { this.state.govHydroWPID.reg }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govHydroWPID.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.govHydroWPID.tb }</div>
                        </div>
                        <div className = "row">
                            <label> treg:&emsp; </label>
                            <div> { this.state.govHydroWPID.treg }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydroWPID.tw }</div>
                        </div>
                        <div className = "row">
                            <label> velmax:&emsp; </label>
                            <div> { this.state.govHydroWPID.velmax }</div>
                        </div>
                        <div className = "row">
                            <label> velmin:&emsp; </label>
                            <div> { this.state.govHydroWPID.velmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroWPIDComponent
