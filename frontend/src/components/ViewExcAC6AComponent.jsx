import React, { Component } from 'react'
import ExcAC6AService from '../services/ExcAC6AService'

class ViewExcAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC6A: {}
        }
    }

    componentDidMount(){
        ExcAC6AService.getExcAC6AById(this.state.id).then( res => {
            this.setState({excAC6A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC6A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAC6A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excAC6A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excAC6A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excAC6A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excAC6A.kh }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excAC6A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excAC6A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excAC6A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAC6A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excAC6A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excAC6A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAC6A.te }</div>
                        </div>
                        <div className = "row">
                            <label> th:&emsp; </label>
                            <div> { this.state.excAC6A.th }</div>
                        </div>
                        <div className = "row">
                            <label> tj:&emsp; </label>
                            <div> { this.state.excAC6A.tj }</div>
                        </div>
                        <div className = "row">
                            <label> tk:&emsp; </label>
                            <div> { this.state.excAC6A.tk }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excAC6A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excAC6A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excAC6A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excAC6A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vfelim:&emsp; </label>
                            <div> { this.state.excAC6A.vfelim }</div>
                        </div>
                        <div className = "row">
                            <label> vhmax:&emsp; </label>
                            <div> { this.state.excAC6A.vhmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excAC6A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excAC6A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC6AComponent
