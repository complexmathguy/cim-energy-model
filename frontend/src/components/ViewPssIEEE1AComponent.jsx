import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService'

class ViewPssIEEE1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE1A: {}
        }
    }

    componentDidMount(){
        PssIEEE1AService.getPssIEEE1AById(this.state.id).then( res => {
            this.setState({pssIEEE1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> a1:&emsp; </label>
                            <div> { this.state.pssIEEE1A.a1 }</div>
                        </div>
                        <div className = "row">
                            <label> a2:&emsp; </label>
                            <div> { this.state.pssIEEE1A.a2 }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignalType:&emsp; </label>
                            <div> { this.state.pssIEEE1A.inputSignalType }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.pssIEEE1A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pssIEEE1A.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.pssIEEE1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.pssIEEE1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE1AComponent
