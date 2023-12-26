import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService'

class ViewPss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss2ST: {}
        }
    }

    componentDidMount(){
        Pss2STService.getPss2STById(this.state.id).then( res => {
            this.setState({pss2ST: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss2ST Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> inputSignal1Type:&emsp; </label>
                            <div> { this.state.pss2ST.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> inputSignal2Type:&emsp; </label>
                            <div> { this.state.pss2ST.inputSignal2Type }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.pss2ST.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.pss2ST.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> lsmax:&emsp; </label>
                            <div> { this.state.pss2ST.lsmax }</div>
                        </div>
                        <div className = "row">
                            <label> lsmin:&emsp; </label>
                            <div> { this.state.pss2ST.lsmin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pss2ST.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t10:&emsp; </label>
                            <div> { this.state.pss2ST.t10 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pss2ST.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pss2ST.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pss2ST.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pss2ST.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pss2ST.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.pss2ST.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.pss2ST.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> t9:&emsp; </label>
                            <div> { this.state.pss2ST.t9 }</div>
                        </div>
                        <div className = "row">
                            <label> vcl:&emsp; </label>
                            <div> { this.state.pss2ST.vcl }</div>
                        </div>
                        <div className = "row">
                            <label> vcu:&emsp; </label>
                            <div> { this.state.pss2ST.vcu }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss2STComponent
