import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service'

class ViewPssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssPTIST3: {}
        }
    }

    componentDidMount(){
        PssPTIST3Service.getPssPTIST3ById(this.state.id).then( res => {
            this.setState({pssPTIST3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssPTIST3 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a0:&emsp; </label>
                            <div> { this.state.pssPTIST3.a0 }</div>
                        </div>
                        <div className = "row">
                            <label> a1:&emsp; </label>
                            <div> { this.state.pssPTIST3.a1 }</div>
                        </div>
                        <div className = "row">
                            <label> a2:&emsp; </label>
                            <div> { this.state.pssPTIST3.a2 }</div>
                        </div>
                        <div className = "row">
                            <label> a3:&emsp; </label>
                            <div> { this.state.pssPTIST3.a3 }</div>
                        </div>
                        <div className = "row">
                            <label> a4:&emsp; </label>
                            <div> { this.state.pssPTIST3.a4 }</div>
                        </div>
                        <div className = "row">
                            <label> a5:&emsp; </label>
                            <div> { this.state.pssPTIST3.a5 }</div>
                        </div>
                        <div className = "row">
                            <label> al:&emsp; </label>
                            <div> { this.state.pssPTIST3.al }</div>
                        </div>
                        <div className = "row">
                            <label> athres:&emsp; </label>
                            <div> { this.state.pssPTIST3.athres }</div>
                        </div>
                        <div className = "row">
                            <label> b0:&emsp; </label>
                            <div> { this.state.pssPTIST3.b0 }</div>
                        </div>
                        <div className = "row">
                            <label> b1:&emsp; </label>
                            <div> { this.state.pssPTIST3.b1 }</div>
                        </div>
                        <div className = "row">
                            <label> b2:&emsp; </label>
                            <div> { this.state.pssPTIST3.b2 }</div>
                        </div>
                        <div className = "row">
                            <label> b3:&emsp; </label>
                            <div> { this.state.pssPTIST3.b3 }</div>
                        </div>
                        <div className = "row">
                            <label> b4:&emsp; </label>
                            <div> { this.state.pssPTIST3.b4 }</div>
                        </div>
                        <div className = "row">
                            <label> b5:&emsp; </label>
                            <div> { this.state.pssPTIST3.b5 }</div>
                        </div>
                        <div className = "row">
                            <label> dl:&emsp; </label>
                            <div> { this.state.pssPTIST3.dl }</div>
                        </div>
                        <div className = "row">
                            <label> dtc:&emsp; </label>
                            <div> { this.state.pssPTIST3.dtc }</div>
                        </div>
                        <div className = "row">
                            <label> dtf:&emsp; </label>
                            <div> { this.state.pssPTIST3.dtf }</div>
                        </div>
                        <div className = "row">
                            <label> dtp:&emsp; </label>
                            <div> { this.state.pssPTIST3.dtp }</div>
                        </div>
                        <div className = "row">
                            <label> isw:&emsp; </label>
                            <div> { this.state.pssPTIST3.isw }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.pssPTIST3.k }</div>
                        </div>
                        <div className = "row">
                            <label> lthres:&emsp; </label>
                            <div> { this.state.pssPTIST3.lthres }</div>
                        </div>
                        <div className = "row">
                            <label> m:&emsp; </label>
                            <div> { this.state.pssPTIST3.m }</div>
                        </div>
                        <div className = "row">
                            <label> nav:&emsp; </label>
                            <div> { this.state.pssPTIST3.nav }</div>
                        </div>
                        <div className = "row">
                            <label> ncl:&emsp; </label>
                            <div> { this.state.pssPTIST3.ncl }</div>
                        </div>
                        <div className = "row">
                            <label> ncr:&emsp; </label>
                            <div> { this.state.pssPTIST3.ncr }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.pssPTIST3.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssPTIST3.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssPTIST3.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssPTIST3.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssPTIST3.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pssPTIST3.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pssPTIST3.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.pssPTIST3.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.pssPTIST3.tp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssPTIST3Component
