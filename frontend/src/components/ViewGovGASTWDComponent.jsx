import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService'

class ViewGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGASTWD: {}
        }
    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDById(this.state.id).then( res => {
            this.setState({govGASTWD: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGASTWD Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a:&emsp; </label>
                            <div> { this.state.govGASTWD.a }</div>
                        </div>
                        <div className = "row">
                            <label> af1:&emsp; </label>
                            <div> { this.state.govGASTWD.af1 }</div>
                        </div>
                        <div className = "row">
                            <label> af2:&emsp; </label>
                            <div> { this.state.govGASTWD.af2 }</div>
                        </div>
                        <div className = "row">
                            <label> b:&emsp; </label>
                            <div> { this.state.govGASTWD.b }</div>
                        </div>
                        <div className = "row">
                            <label> bf1:&emsp; </label>
                            <div> { this.state.govGASTWD.bf1 }</div>
                        </div>
                        <div className = "row">
                            <label> bf2:&emsp; </label>
                            <div> { this.state.govGASTWD.bf2 }</div>
                        </div>
                        <div className = "row">
                            <label> c:&emsp; </label>
                            <div> { this.state.govGASTWD.c }</div>
                        </div>
                        <div className = "row">
                            <label> cf2:&emsp; </label>
                            <div> { this.state.govGASTWD.cf2 }</div>
                        </div>
                        <div className = "row">
                            <label> ecr:&emsp; </label>
                            <div> { this.state.govGASTWD.ecr }</div>
                        </div>
                        <div className = "row">
                            <label> etd:&emsp; </label>
                            <div> { this.state.govGASTWD.etd }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.govGASTWD.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.govGASTWD.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> k5:&emsp; </label>
                            <div> { this.state.govGASTWD.k5 }</div>
                        </div>
                        <div className = "row">
                            <label> k6:&emsp; </label>
                            <div> { this.state.govGASTWD.k6 }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.govGASTWD.kd }</div>
                        </div>
                        <div className = "row">
                            <label> kdroop:&emsp; </label>
                            <div> { this.state.govGASTWD.kdroop }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.govGASTWD.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.govGASTWD.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.govGASTWD.kp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govGASTWD.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> t:&emsp; </label>
                            <div> { this.state.govGASTWD.t }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govGASTWD.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govGASTWD.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.govGASTWD.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.govGASTWD.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tcd:&emsp; </label>
                            <div> { this.state.govGASTWD.tcd }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.govGASTWD.td }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.govGASTWD.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tmax:&emsp; </label>
                            <div> { this.state.govGASTWD.tmax }</div>
                        </div>
                        <div className = "row">
                            <label> tmin:&emsp; </label>
                            <div> { this.state.govGASTWD.tmin }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.govGASTWD.tr }</div>
                        </div>
                        <div className = "row">
                            <label> trate:&emsp; </label>
                            <div> { this.state.govGASTWD.trate }</div>
                        </div>
                        <div className = "row">
                            <label> tt:&emsp; </label>
                            <div> { this.state.govGASTWD.tt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGASTWDComponent
