import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService'

class ViewExcIEEEAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC6A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC6AService.getExcIEEEAC6AById(this.state.id).then( res => {
            this.setState({excIEEEAC6A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC6A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.kh }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.te }</div>
                        </div>
                        <div className = "row">
                            <label> th:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.th }</div>
                        </div>
                        <div className = "row">
                            <label> tj:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.tj }</div>
                        </div>
                        <div className = "row">
                            <label> tk:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.tk }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vfelim:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vfelim }</div>
                        </div>
                        <div className = "row">
                            <label> vhmax:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vhmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC6A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC6AComponent
