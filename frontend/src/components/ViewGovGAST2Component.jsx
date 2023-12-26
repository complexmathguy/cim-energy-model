import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service'

class ViewGovGAST2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST2: {}
        }
    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2ById(this.state.id).then( res => {
            this.setState({govGAST2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a:&emsp; </label>
                            <div> { this.state.govGAST2.a }</div>
                        </div>
                        <div className = "row">
                            <label> af1:&emsp; </label>
                            <div> { this.state.govGAST2.af1 }</div>
                        </div>
                        <div className = "row">
                            <label> af2:&emsp; </label>
                            <div> { this.state.govGAST2.af2 }</div>
                        </div>
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.govGAST2.b }</div>
                        </div>
                        <div className = "row">
                            <label> bf1:&emsp; </label>
                            <div> { this.state.govGAST2.bf1 }</div>
                        </div>
                        <div className = "row">
                            <label> bf2:&emsp; </label>
                            <div> { this.state.govGAST2.bf2 }</div>
                        </div>
                        <div className = "row">
                            <label> c:&emsp; </label>
                            <div> { this.state.govGAST2.c }</div>
                        </div>
                        <div className = "row">
                            <label> cf2:&emsp; </label>
                            <div> { this.state.govGAST2.cf2 }</div>
                        </div>
                        <div className = "row">
                            <label> ecr:&emsp; </label>
                            <div> { this.state.govGAST2.ecr }</div>
                        </div>
                        <div className = "row">
                            <label> etd:&emsp; </label>
                            <div> { this.state.govGAST2.etd }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.govGAST2.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.govGAST2.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> k5:&emsp; </label>
                            <div> { this.state.govGAST2.k5 }</div>
                        </div>
                        <div className = "row">
                            <label> k6:&emsp; </label>
                            <div> { this.state.govGAST2.k6 }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.govGAST2.kf }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govGAST2.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> t:&emsp; </label>
                            <div> { this.state.govGAST2.t }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govGAST2.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govGAST2.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govGAST2.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govGAST2.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tcd:&emsp; </label>
                            <div> { this.state.govGAST2.tcd }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.govGAST2.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tmax:&emsp; </label>
                            <div> { this.state.govGAST2.tmax }</div>
                        </div>
                        <div className = "row">
                            <label> tmin:&emsp; </label>
                            <div> { this.state.govGAST2.tmin }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.govGAST2.tr }</div>
                        </div>
                        <div className = "row">
                            <label> trate:&emsp; </label>
                            <div> { this.state.govGAST2.trate }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govGAST2.tt }</div>
                        </div>
                        <div className = "row">
                            <label> w:&emsp; </label>
                            <div> { this.state.govGAST2.w }</div>
                        </div>
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.govGAST2.x }</div>
                        </div>
                        <div className = "row">
                            <label> y:&emsp; </label>
                            <div> { this.state.govGAST2.y }</div>
                        </div>
                        <div className = "row">
                            <label> z:&emsp; </label>
                            <div> { this.state.govGAST2.z }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST2Component
