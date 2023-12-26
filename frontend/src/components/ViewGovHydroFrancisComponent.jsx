import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService'

class ViewGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroFrancis: {}
        }
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFrancisById(this.state.id).then( res => {
            this.setState({govHydroFrancis: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroFrancis Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> am:&emsp; </label>
                            <div> { this.state.govHydroFrancis.am }</div>
                        </div>
                        <div className = "row">
                            <label> av0:&emsp; </label>
                            <div> { this.state.govHydroFrancis.av0 }</div>
                        </div>
                        <div className = "row">
                            <label> av1:&emsp; </label>
                            <div> { this.state.govHydroFrancis.av1 }</div>
                        </div>
                        <div className = "row">
                            <label> bp:&emsp; </label>
                            <div> { this.state.govHydroFrancis.bp }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govHydroFrancis.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> etamax:&emsp; </label>
                            <div> { this.state.govHydroFrancis.etamax }</div>
                        </div>
                        <div className = "row">
                            <label> governorControl:&emsp; </label>
                            <div> { this.state.govHydroFrancis.governorControl }</div>
                        </div>
                        <div className = "row">
                            <label> h1:&emsp; </label>
                            <div> { this.state.govHydroFrancis.h1 }</div>
                        </div>
                        <div className = "row">
                            <label> h2:&emsp; </label>
                            <div> { this.state.govHydroFrancis.h2 }</div>
                        </div>
                        <div className = "row">
                            <label> hn:&emsp; </label>
                            <div> { this.state.govHydroFrancis.hn }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.govHydroFrancis.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.govHydroFrancis.kg }</div>
                        </div>
                        <div className = "row">
                            <label> kt:&emsp; </label>
                            <div> { this.state.govHydroFrancis.kt }</div>
                        </div>
                        <div className = "row">
                            <label> qc0:&emsp; </label>
                            <div> { this.state.govHydroFrancis.qc0 }</div>
                        </div>
                        <div className = "row">
                            <label> qn:&emsp; </label>
                            <div> { this.state.govHydroFrancis.qn }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.govHydroFrancis.ta }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govHydroFrancis.td }</div>
                        </div>
                        <div className = "row">
                            <label> ts:&emsp; </label>
                            <div> { this.state.govHydroFrancis.ts }</div>
                        </div>
                        <div className = "row">
                            <label> twnc:&emsp; </label>
                            <div> { this.state.govHydroFrancis.twnc }</div>
                        </div>
                        <div className = "row">
                            <label> twng:&emsp; </label>
                            <div> { this.state.govHydroFrancis.twng }</div>
                        </div>
                        <div className = "row">
                            <label> tx:&emsp; </label>
                            <div> { this.state.govHydroFrancis.tx }</div>
                        </div>
                        <div className = "row">
                            <label> va:&emsp; </label>
                            <div> { this.state.govHydroFrancis.va }</div>
                        </div>
                        <div className = "row">
                            <label> valvmax:&emsp; </label>
                            <div> { this.state.govHydroFrancis.valvmax }</div>
                        </div>
                        <div className = "row">
                            <label> valvmin:&emsp; </label>
                            <div> { this.state.govHydroFrancis.valvmin }</div>
                        </div>
                        <div className = "row">
                            <label> vc:&emsp; </label>
                            <div> { this.state.govHydroFrancis.vc }</div>
                        </div>
                        <div className = "row">
                            <label> waterTunnelSurgeChamberSimulation:&emsp; </label>
                            <div> { this.state.govHydroFrancis.waterTunnelSurgeChamberSimulation }</div>
                        </div>
                        <div className = "row">
                            <label> zsfc:&emsp; </label>
                            <div> { this.state.govHydroFrancis.zsfc }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroFrancisComponent
