import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service'

class ViewGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST1: {}
        }
    }

    componentDidMount(){
        GovGAST1Service.getGovGAST1ById(this.state.id).then( res => {
            this.setState({govGAST1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a:&emsp; </label>
                            <div> { this.state.govGAST1.a }</div>
                        </div>
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.govGAST1.b }</div>
                        </div>
                        <div className = "row">
                            <label> db1:&emsp; </label>
                            <div> { this.state.govGAST1.db1 }</div>
                        </div>
                        <div className = "row">
                            <label> db2:&emsp; </label>
                            <div> { this.state.govGAST1.db2 }</div>
                        </div>
                        <div className = "row">
                            <label> eps:&emsp; </label>
                            <div> { this.state.govGAST1.eps }</div>
                        </div>
                        <div className = "row">
                            <label> fidle:&emsp; </label>
                            <div> { this.state.govGAST1.fidle }</div>
                        </div>
                        <div className = "row">
                            <label> gv1:&emsp; </label>
                            <div> { this.state.govGAST1.gv1 }</div>
                        </div>
                        <div className = "row">
                            <label> gv2:&emsp; </label>
                            <div> { this.state.govGAST1.gv2 }</div>
                        </div>
                        <div className = "row">
                            <label> gv3:&emsp; </label>
                            <div> { this.state.govGAST1.gv3 }</div>
                        </div>
                        <div className = "row">
                            <label> gv4:&emsp; </label>
                            <div> { this.state.govGAST1.gv4 }</div>
                        </div>
                        <div className = "row">
                            <label> gv5:&emsp; </label>
                            <div> { this.state.govGAST1.gv5 }</div>
                        </div>
                        <div className = "row">
                            <label> gv6:&emsp; </label>
                            <div> { this.state.govGAST1.gv6 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.govGAST1.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kt:&emsp; </label>
                            <div> { this.state.govGAST1.kt }</div>
                        </div>
                        <div className = "row">
                            <label> lmax:&emsp; </label>
                            <div> { this.state.govGAST1.lmax }</div>
                        </div>
                        <div className = "row">
                            <label> loadinc:&emsp; </label>
                            <div> { this.state.govGAST1.loadinc }</div>
                        </div>
                        <div className = "row">
                            <label> ltrate:&emsp; </label>
                            <div> { this.state.govGAST1.ltrate }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govGAST1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pgv1:&emsp; </label>
                            <div> { this.state.govGAST1.pgv1 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv2:&emsp; </label>
                            <div> { this.state.govGAST1.pgv2 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv3:&emsp; </label>
                            <div> { this.state.govGAST1.pgv3 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv4:&emsp; </label>
                            <div> { this.state.govGAST1.pgv4 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv5:&emsp; </label>
                            <div> { this.state.govGAST1.pgv5 }</div>
                        </div>
                        <div className = "row">
                            <label> pgv6:&emsp; </label>
                            <div> { this.state.govGAST1.pgv6 }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.govGAST1.r }</div>
                        </div>
                        <div className = "row">
                            <label> rmax:&emsp; </label>
                            <div> { this.state.govGAST1.rmax }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govGAST1.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govGAST1.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govGAST1.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govGAST1.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govGAST1.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> tltr:&emsp; </label>
                            <div> { this.state.govGAST1.tltr }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.govGAST1.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.govGAST1.vmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST1Component
