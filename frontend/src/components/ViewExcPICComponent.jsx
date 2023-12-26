import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService'

class ViewExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excPIC: {}
        }
    }

    componentDidMount(){
        ExcPICService.getExcPICById(this.state.id).then( res => {
            this.setState({excPIC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcPIC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excPIC.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excPIC.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excPIC.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excPIC.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excPIC.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excPIC.kc }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excPIC.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excPIC.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excPIC.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excPIC.kp }</div>
                        </div>
                        <div className = "row">
                            <label> se1:&emsp; </label>
                            <div> { this.state.excPIC.se1 }</div>
                        </div>
                        <div className = "row">
                            <label> se2:&emsp; </label>
                            <div> { this.state.excPIC.se2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta1:&emsp; </label>
                            <div> { this.state.excPIC.ta1 }</div>
                        </div>
                        <div className = "row">
                            <label> ta2:&emsp; </label>
                            <div> { this.state.excPIC.ta2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta3:&emsp; </label>
                            <div> { this.state.excPIC.ta3 }</div>
                        </div>
                        <div className = "row">
                            <label> ta4:&emsp; </label>
                            <div> { this.state.excPIC.ta4 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excPIC.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.excPIC.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.excPIC.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> vr1:&emsp; </label>
                            <div> { this.state.excPIC.vr1 }</div>
                        </div>
                        <div className = "row">
                            <label> vr2:&emsp; </label>
                            <div> { this.state.excPIC.vr2 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excPIC.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excPIC.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcPICComponent
