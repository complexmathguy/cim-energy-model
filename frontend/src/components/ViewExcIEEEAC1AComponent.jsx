import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService'

class ViewExcIEEEAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC1AService.getExcIEEEAC1AById(this.state.id).then( res => {
            this.setState({excIEEEAC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC1AComponent
