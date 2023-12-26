import React, { Component } from 'react'
import PssIEEE3BService from '../services/PssIEEE3BService'

class ViewPssIEEE3BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE3B: {}
        }
    }

    componentDidMount(){
        PssIEEE3BService.getPssIEEE3BById(this.state.id).then( res => {
            this.setState({pssIEEE3B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE3B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a1:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a1 }</div>
                        </div>
                        <div className = "row">
                            <label> a2:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a2 }</div>
                        </div>
                        <div className = "row">
                            <label> a3:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a3 }</div>
                        </div>
                        <div className = "row">
                            <label> a4:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a4 }</div>
                        </div>
                        <div className = "row">
                            <label> a5:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a5 }</div>
                        </div>
                        <div className = "row">
                            <label> a6:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a6 }</div>
                        </div>
                        <div className = "row">
                            <label> a7:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a7 }</div>
                        </div>
                        <div className = "row">
                            <label> a8:&emsp; </label>
                            <div> { this.state.pssIEEE3B.a8 }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal1Type:&emsp; </label>
                            <div> { this.state.pssIEEE3B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal2Type:&emsp; </label>
                            <div> { this.state.pssIEEE3B.inputSignal2Type }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.pssIEEE3B.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks2:&emsp; </label>
                            <div> { this.state.pssIEEE3B.ks2 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssIEEE3B.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssIEEE3B.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> tw1:&emsp; </label>
                            <div> { this.state.pssIEEE3B.tw1 }</div>
                        </div>
                        <div className = "row">
                            <label> tw2:&emsp; </label>
                            <div> { this.state.pssIEEE3B.tw2 }</div>
                        </div>
                        <div className = "row">
                            <label> tw3:&emsp; </label>
                            <div> { this.state.pssIEEE3B.tw3 }</div>
                        </div>
                        <div className = "row">
                            <label> vstmax:&emsp; </label>
                            <div> { this.state.pssIEEE3B.vstmax }</div>
                        </div>
                        <div className = "row">
                            <label> vstmin:&emsp; </label>
                            <div> { this.state.pssIEEE3B.vstmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE3BComponent
