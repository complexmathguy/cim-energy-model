import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService'

class ViewExcAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC2A: {}
        }
    }

    componentDidMount(){
        ExcAC2AService.getExcAC2AById(this.state.id).then( res => {
            this.setState({excAC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC2A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> hvgate:&emsp; </label>
                            <div> { this.state.excAC2A.hvgate }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAC2A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kb:&emsp; </label>
                            <div> { this.state.excAC2A.kb }</div>
                        </div>
                        <div className = "row">
                            <label> kb1:&emsp; </label>
                            <div> { this.state.excAC2A.kb1 }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excAC2A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excAC2A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excAC2A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excAC2A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excAC2A.kh }</div>
                        </div>
                        <div className = "row">
                            <label> kl:&emsp; </label>
                            <div> { this.state.excAC2A.kl }</div>
                        </div>
                        <div className = "row">
                            <label> kl1:&emsp; </label>
                            <div> { this.state.excAC2A.kl1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excAC2A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> lvgate:&emsp; </label>
                            <div> { this.state.excAC2A.lvgate }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excAC2A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excAC2A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAC2A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excAC2A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excAC2A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAC2A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excAC2A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excAC2A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excAC2A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excAC2A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excAC2A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excAC2A.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vlr:&emsp; </label>
                            <div> { this.state.excAC2A.vlr }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excAC2A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excAC2A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC2AComponent
