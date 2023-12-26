import React, { Component } from 'react'
import PssIEEE2BService from '../services/PssIEEE2BService'

class ViewPssIEEE2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE2B: {}
        }
    }

    componentDidMount(){
        PssIEEE2BService.getPssIEEE2BById(this.state.id).then( res => {
            this.setState({pssIEEE2B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE2B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inputSignal1Type:&emsp; </label>
                            <div> { this.state.pssIEEE2B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal2Type:&emsp; </label>
                            <div> { this.state.pssIEEE2B.inputSignal2Type }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.pssIEEE2B.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks2:&emsp; </label>
                            <div> { this.state.pssIEEE2B.ks2 }</div>
                        </div>
                        <div className = "row">
                            <label> ks3:&emsp; </label>
                            <div> { this.state.pssIEEE2B.ks3 }</div>
                        </div>
                        <div className = "row">
                            <label> m:&emsp; </label>
                            <div> { this.state.pssIEEE2B.m }</div>
                        </div>
                        <div className = "row">
                            <label> n:&emsp; </label>
                            <div> { this.state.pssIEEE2B.n }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t10:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t10 }</div>
                        </div>
                        <div className = "row">
                            <label> t11:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t11 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> t9:&emsp; </label>
                            <div> { this.state.pssIEEE2B.t9 }</div>
                        </div>
                        <div className = "row">
                            <label> tw1:&emsp; </label>
                            <div> { this.state.pssIEEE2B.tw1 }</div>
                        </div>
                        <div className = "row">
                            <label> tw2:&emsp; </label>
                            <div> { this.state.pssIEEE2B.tw2 }</div>
                        </div>
                        <div className = "row">
                            <label> tw3:&emsp; </label>
                            <div> { this.state.pssIEEE2B.tw3 }</div>
                        </div>
                        <div className = "row">
                            <label> tw4:&emsp; </label>
                            <div> { this.state.pssIEEE2B.tw4 }</div>
                        </div>
                        <div className = "row">
                            <label> vsi1max:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vsi1max }</div>
                        </div>
                        <div className = "row">
                            <label> vsi1min:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vsi1min }</div>
                        </div>
                        <div className = "row">
                            <label> vsi2max:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vsi2max }</div>
                        </div>
                        <div className = "row">
                            <label> vsi2min:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vsi2min }</div>
                        </div>
                        <div className = "row">
                            <label> vstmax:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vstmax }</div>
                        </div>
                        <div className = "row">
                            <label> vstmin:&emsp; </label>
                            <div> { this.state.pssIEEE2B.vstmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE2BComponent
