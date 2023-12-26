import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService'

class ViewPss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss1A: {}
        }
    }

    componentDidMount(){
        Pss1AService.getPss1AById(this.state.id).then( res => {
            this.setState({pss1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a1:&emsp; </label>
                            <div> { this.state.pss1A.a1 }</div>
                        </div>
                        <div className = "row">
                            <label> a2:&emsp; </label>
                            <div> { this.state.pss1A.a2 }</div>
                        </div>
                        <div className = "row">
                            <label> a3:&emsp; </label>
                            <div> { this.state.pss1A.a3 }</div>
                        </div>
                        <div className = "row">
                            <label> a4:&emsp; </label>
                            <div> { this.state.pss1A.a4 }</div>
                        </div>
                        <div className = "row">
                            <label> a5:&emsp; </label>
                            <div> { this.state.pss1A.a5 }</div>
                        </div>
                        <div className = "row">
                            <label> a6:&emsp; </label>
                            <div> { this.state.pss1A.a6 }</div>
                        </div>
                        <div className = "row">
                            <label> a7:&emsp; </label>
                            <div> { this.state.pss1A.a7 }</div>
                        </div>
                        <div className = "row">
                            <label> a8:&emsp; </label>
                            <div> { this.state.pss1A.a8 }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignalType:&emsp; </label>
                            <div> { this.state.pss1A.inputSignalType }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.pss1A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.pss1A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pss1A.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pss1A.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pss1A.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pss1A.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pss1A.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pss1A.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> tdelay:&emsp; </label>
                            <div> { this.state.pss1A.tdelay }</div>
                        </div>
                        <div className = "row">
                            <label> vcl:&emsp; </label>
                            <div> { this.state.pss1A.vcl }</div>
                        </div>
                        <div className = "row">
                            <label> vcu:&emsp; </label>
                            <div> { this.state.pss1A.vcu }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.pss1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.pss1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss1AComponent
