import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService'

class ViewExcAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC3A: {}
        }
    }

    componentDidMount(){
        ExcAC3AService.getExcAC3AById(this.state.id).then( res => {
            this.setState({excAC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdn:&emsp; </label>
                            <div> { this.state.excAC3A.efdn }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excAC3A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excAC3A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excAC3A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excAC3A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excAC3A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kf1:&emsp; </label>
                            <div> { this.state.excAC3A.kf1 }</div>
                        </div>
                        <div className = "row">
                            <label> kf2:&emsp; </label>
                            <div> { this.state.excAC3A.kf2 }</div>
                        </div>
                        <div className = "row">
                            <label> klv:&emsp; </label>
                            <div> { this.state.excAC3A.klv }</div>
                        </div>
                        <div className = "row">
                            <label> kn:&emsp; </label>
                            <div> { this.state.excAC3A.kn }</div>
                        </div>
                        <div className = "row">
                            <label> kr:&emsp; </label>
                            <div> { this.state.excAC3A.kr }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excAC3A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excAC3A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excAC3A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excAC3A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excAC3A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excAC3A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excAC3A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excAC3A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excAC3A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excAC3A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excAC3A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excAC3A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vemin:&emsp; </label>
                            <div> { this.state.excAC3A.vemin }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excAC3A.vfemax }</div>
                        </div>
                        <div className = "row">
                            <label> vlv:&emsp; </label>
                            <div> { this.state.excAC3A.vlv }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC3AComponent
