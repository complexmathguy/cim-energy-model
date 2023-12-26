import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService'

class ViewPssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssWECC: {}
        }
    }

    componentDidMount(){
        PssWECCService.getPssWECCById(this.state.id).then( res => {
            this.setState({pssWECC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssWECC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inputSignal1Type:&emsp; </label>
                            <div> { this.state.pssWECC.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal2Type:&emsp; </label>
                            <div> { this.state.pssWECC.inputSignal2Type }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.pssWECC.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.pssWECC.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssWECC.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t10:&emsp; </label>
                            <div> { this.state.pssWECC.t10 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssWECC.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssWECC.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssWECC.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pssWECC.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pssWECC.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.pssWECC.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.pssWECC.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> t9:&emsp; </label>
                            <div> { this.state.pssWECC.t9 }</div>
                        </div>
                        <div className = "row">
                            <label> vcl:&emsp; </label>
                            <div> { this.state.pssWECC.vcl }</div>
                        </div>
                        <div className = "row">
                            <label> vcu:&emsp; </label>
                            <div> { this.state.pssWECC.vcu }</div>
                        </div>
                        <div className = "row">
                            <label> vsmax:&emsp; </label>
                            <div> { this.state.pssWECC.vsmax }</div>
                        </div>
                        <div className = "row">
                            <label> vsmin:&emsp; </label>
                            <div> { this.state.pssWECC.vsmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssWECCComponent
