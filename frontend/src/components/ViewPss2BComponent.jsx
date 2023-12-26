import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService'

class ViewPss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss2B: {}
        }
    }

    componentDidMount(){
        Pss2BService.getPss2BById(this.state.id).then( res => {
            this.setState({pss2B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss2B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a:&emsp; </label>
                            <div> { this.state.pss2B.a }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal1Type:&emsp; </label>
                            <div> { this.state.pss2B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal2Type:&emsp; </label>
                            <div> { this.state.pss2B.inputSignal2Type }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.pss2B.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks2:&emsp; </label>
                            <div> { this.state.pss2B.ks2 }</div>
                        </div>
                        <div className = "row">
                            <label> ks3:&emsp; </label>
                            <div> { this.state.pss2B.ks3 }</div>
                        </div>
                        <div className = "row">
                            <label> ks4:&emsp; </label>
                            <div> { this.state.pss2B.ks4 }</div>
                        </div>
                        <div className = "row">
                            <label> m:&emsp; </label>
                            <div> { this.state.pss2B.m }</div>
                        </div>
                        <div className = "row">
                            <label> n:&emsp; </label>
                            <div> { this.state.pss2B.n }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pss2B.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t10:&emsp; </label>
                            <div> { this.state.pss2B.t10 }</div>
                        </div>
                        <div className = "row">
                            <label> t11:&emsp; </label>
                            <div> { this.state.pss2B.t11 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pss2B.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pss2B.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pss2B.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pss2B.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.pss2B.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.pss2B.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> t9:&emsp; </label>
                            <div> { this.state.pss2B.t9 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.pss2B.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.pss2B.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tw1:&emsp; </label>
                            <div> { this.state.pss2B.tw1 }</div>
                        </div>
                        <div className = "row">
                            <label> tw2:&emsp; </label>
                            <div> { this.state.pss2B.tw2 }</div>
                        </div>
                        <div className = "row">
                            <label> tw3:&emsp; </label>
                            <div> { this.state.pss2B.tw3 }</div>
                        </div>
                        <div className = "row">
                            <label> tw4:&emsp; </label>
                            <div> { this.state.pss2B.tw4 }</div>
                        </div>
                        <div className = "row">
                            <label> vsi1max:&emsp; </label>
                            <div> { this.state.pss2B.vsi1max }</div>
                        </div>
                        <div className = "row">
                            <label> vsi1min:&emsp; </label>
                            <div> { this.state.pss2B.vsi1min }</div>
                        </div>
                        <div className = "row">
                            <label> vsi2max:&emsp; </label>
                            <div> { this.state.pss2B.vsi2max }</div>
                        </div>
                        <div className = "row">
                            <label> vsi2min:&emsp; </label>
                            <div> { this.state.pss2B.vsi2min }</div>
                        </div>
                        <div className = "row">
                            <label> vstmax:&emsp; </label>
                            <div> { this.state.pss2B.vstmax }</div>
                        </div>
                        <div className = "row">
                            <label> vstmin:&emsp; </label>
                            <div> { this.state.pss2B.vstmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss2BComponent
