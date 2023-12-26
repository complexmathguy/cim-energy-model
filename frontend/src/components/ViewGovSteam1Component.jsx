import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service'

class ViewGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam1: {}
        }
    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1ById(this.state.id).then( res => {
            this.setState({govSteam1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govSteam1.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govSteam1.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> eps:&emsp; </label>
                            <div> { this.state.govSteam1.eps }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govSteam1.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govSteam1.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govSteam1.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govSteam1.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govSteam1.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> gv6:&emsp; </label>
                            <div> { this.state.govSteam1.gv6 }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govSteam1.k }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.govSteam1.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.govSteam1.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.govSteam1.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.govSteam1.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> k5:&emsp; </label>
                            <div> { this.state.govSteam1.k5 }</div>
                        </div>
                        <div className = "row">
                            <label> k6:&emsp; </label>
                            <div> { this.state.govSteam1.k6 }</div>
                        </div>
                        <div className = "row">
                            <label> k7:&emsp; </label>
                            <div> { this.state.govSteam1.k7 }</div>
                        </div>
                        <div className = "row">
                            <label> k8:&emsp; </label>
                            <div> { this.state.govSteam1.k8 }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govSteam1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govSteam1.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govSteam1.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govSteam1.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govSteam1.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govSteam1.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv6:&emsp; </label>
                            <div> { this.state.govSteam1.pgv6 }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govSteam1.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govSteam1.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> sdb1:&emsp; </label>
                            <div> { this.state.govSteam1.sdb1 }</div>
                        </div>
                        <div className = "row">
                            <label> sdb2:&emsp; </label>
                            <div> { this.state.govSteam1.sdb2 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govSteam1.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govSteam1.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govSteam1.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govSteam1.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govSteam1.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.govSteam1.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.govSteam1.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> uc:&emsp; </label>
                            <div> { this.state.govSteam1.uc }</div>
                        </div>
                        <div className = "row">
                            <label> uo:&emsp; </label>
                            <div> { this.state.govSteam1.uo }</div>
                        </div>
                        <div className = "row">
                            <label> valve:&emsp; </label>
                            <div> { this.state.govSteam1.valve }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam1Component
