import React, { Component } from 'react'
import PssPTIST1Service from '../services/PssPTIST1Service'

class ViewPssPTIST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssPTIST1: {}
        }
    }

    componentDidMount(){
        PssPTIST1Service.getPssPTIST1ById(this.state.id).then( res => {
            this.setState({pssPTIST1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssPTIST1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dtc:&emsp; </label>
                            <div> { this.state.pssPTIST1.dtc }</div>
                        </div>
                        <div className = "row">
                            <label> dtf:&emsp; </label>
                            <div> { this.state.pssPTIST1.dtf }</div>
                        </div>
                        <div className = "row">
                            <label> dtp:&emsp; </label>
                            <div> { this.state.pssPTIST1.dtp }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.pssPTIST1.k }</div>
                        </div>
                        <div className = "row">
                            <label> m:&emsp; </label>
                            <div> { this.state.pssPTIST1.m }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssPTIST1.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssPTIST1.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssPTIST1.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssPTIST1.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.pssPTIST1.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.pssPTIST1.tp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssPTIST1Component
