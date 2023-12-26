import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService'

class ViewExcIEEEAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC3AService.getExcIEEEAC3AById(this.state.id).then( res => {
            this.setState({excIEEEAC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdn:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.efdn }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kn:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.kn }</div>
                        </div>
                        <div className = "row">
                            <label> kr:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.kr }</div>
                        </div>
                        <div className = "row">
                            <label> seve1:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.seve1 }</div>
                        </div>
                        <div className = "row">
                            <label> seve2:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.seve2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> ve1:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.ve1 }</div>
                        </div>
                        <div className = "row">
                            <label> ve2:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.ve2 }</div>
                        </div>
                        <div className = "row">
                            <label> vemin:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.vemin }</div>
                        </div>
                        <div className = "row">
                            <label> vfemax:&emsp; </label>
                            <div> { this.state.excIEEEAC3A.vfemax }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC3AComponent
