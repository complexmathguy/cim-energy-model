import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service'

class ViewGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro4: {}
        }
    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4ById(this.state.id).then( res => {
            this.setState({govHydro4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro4 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> at:&emsp; </label>
                            <div> { this.state.govHydro4.at }</div>
                        </div>
                        <div className = "row">
                            <label> bgv0:&emsp; </label>
                            <div> { this.state.govHydro4.bgv0 }</div>
                        </div>
                        <div className = "row">
                            <label> bgv1:&emsp; </label>
                            <div> { this.state.govHydro4.bgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> bgv2:&emsp; </label>
                            <div> { this.state.govHydro4.bgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> bgv3:&emsp; </label>
                            <div> { this.state.govHydro4.bgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> bgv4:&emsp; </label>
                            <div> { this.state.govHydro4.bgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> bgv5:&emsp; </label>
                            <div> { this.state.govHydro4.bgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> bmax:&emsp; </label>
                            <div> { this.state.govHydro4.bmax }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govHydro4.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govHydro4.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> dturb:&emsp; </label>
                            <div> { this.state.govHydro4.dturb }</div>
                        </div>
                        <div className = "row">
                            <label> eps:&emsp; </label>
                            <div> { this.state.govHydro4.eps }</div>
                        </div>
                        <div className = "row">
                            <label> gmax:&emsp; </label>
                            <div> { this.state.govHydro4.gmax }</div>
                        </div>
                        <div className = "row">
                            <label> gmin:&emsp; </label>
                            <div> { this.state.govHydro4.gmin }</div>
                        </div>
                        <div className = "row">
                            <label> gv0:&emsp; </label>
                            <div> { this.state.govHydro4.gv0 }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govHydro4.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govHydro4.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govHydro4.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govHydro4.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govHydro4.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> hdam:&emsp; </label>
                            <div> { this.state.govHydro4.hdam }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydro4.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv0:&emsp; </label>
                            <div> { this.state.govHydro4.pgv0 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govHydro4.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govHydro4.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govHydro4.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govHydro4.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govHydro4.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> qn1:&emsp; </label>
                            <div> { this.state.govHydro4.qn1 }</div>
                        </div>
                        <div className = "row">
                            <label> rperm:&emsp; </label>
                            <div> { this.state.govHydro4.rperm }</div>
                        </div>
                        <div className = "row">
                            <label> rtemp:&emsp; </label>
                            <div> { this.state.govHydro4.rtemp }</div>
                        </div>
                        <div className = "row">
                            <label> tblade:&emsp; </label>
                            <div> { this.state.govHydro4.tblade }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.govHydro4.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.govHydro4.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.govHydro4.tr }</div>
                        </div>
                        <div className = "row">
                            <label> tw:&emsp; </label>
                            <div> { this.state.govHydro4.tw }</div>
                        </div>
                        <div className = "row">
                            <label> uc:&emsp; </label>
                            <div> { this.state.govHydro4.uc }</div>
                        </div>
                        <div className = "row">
                            <label> uo:&emsp; </label>
                            <div> { this.state.govHydro4.uo }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro4Component
