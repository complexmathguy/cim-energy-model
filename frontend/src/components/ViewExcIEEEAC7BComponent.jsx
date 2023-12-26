import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService'

class ViewExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC7B: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7BById(this.state.id).then( res => {
            this.setState({excIEEEAC7B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC7B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kd }</div>
                        </div>
                        <div className = "row">
                            <label> kdr:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kdr }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf1:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kf1 }</div>
                        </div>
                        <div className = "row">
                            <label> kf2:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kf2 }</div>
                        </div>
                        <div className = "row">
                            <label> kf3:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kf3 }</div>
                        </div>
                        <div className = "row">
                            <label> kia:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kia }</div>
                        </div>
                        <div className = "row">
                            <label> kir:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kir }</div>
                        </div>
                        <div className = "row">
                            <label> kl:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kl }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kp }</div>
                        </div>
                        <div className = "row">
                            <label> kpa:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kpa }</div>
                        </div>
                        <div className = "row">
                            <label> kpr:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.kpr }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> tdr:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.tdr }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vemin:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vemin }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC7B.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC7BComponent
