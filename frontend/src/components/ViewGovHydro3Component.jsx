import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service'

class ViewGovHydro3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro3: {}
        }
    }

    componentDidMount(){
        GovHydro3Service.getGovHydro3ById(this.state.id).then( res => {
            this.setState({govHydro3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro3 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> at:&emsp; </label>
                            <div> { this.state.govHydro3.at }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govHydro3.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govHydro3.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govHydro3.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> eps:&emsp; </label>
                            <div> { this.state.govHydro3.eps }</div>
                        </div>
                        <div className = "row">
                            <label> governorControl:&emsp; </label>
                            <div> { this.state.govHydro3.governorControl }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydro3.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydro3.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydro3.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govHydro3.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govHydro3.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> gv6:&emsp; </label>
                            <div> { this.state.govHydro3.gv6 }</div>
                        </div>
                        <div className = "row">
                            <label> h0:&emsp; </label>
                            <div> { this.state.govHydro3.h0 }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.govHydro3.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.govHydro3.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.govHydro3.kg }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govHydro3.ki }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydro3.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govHydro3.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govHydro3.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govHydro3.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govHydro3.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govHydro3.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv6:&emsp; </label>
                            <div> { this.state.govHydro3.pgv6 }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govHydro3.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govHydro3.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> qnl:&emsp; </label>
                            <div> { this.state.govHydro3.qnl }</div>
                        </div>
                        <div className = "row">
                            <label> relec:&emsp; </label>
                            <div> { this.state.govHydro3.relec }</div>
                        </div>
                        <div className = "row">
                            <label> rgate:&emsp; </label>
                            <div> { this.state.govHydro3.rgate }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govHydro3.td }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.govHydro3.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govHydro3.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govHydro3.tt }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydro3.tw }</div>
                        </div>
                        <div className = "row">
                            <label> velcl:&emsp; </label>
                            <div> { this.state.govHydro3.velcl }</div>
                        </div>
                        <div className = "row">
                            <label> velop:&emsp; </label>
                            <div> { this.state.govHydro3.velop }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro3Component
