import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService'

class ViewExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC2A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC2AService.getExcIEEEAC2AById(this.state.id).then( res => {
            this.setState({excIEEEAC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC2A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kb:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.kb }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.kh }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC2A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC2AComponent
