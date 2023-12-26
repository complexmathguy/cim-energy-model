import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service'

class ViewExcDC3A1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC3A1: {}
        }
    }

    componentDidMount(){
        ExcDC3A1Service.getExcDC3A1ById(this.state.id).then( res => {
            this.setState({excDC3A1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC3A1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excDC3A1.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excDC3A1.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excDC3A1.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excDC3A1.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excDC3A1.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excDC3A1.kp }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excDC3A1.ta }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excDC3A1.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excDC3A1.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vb1max:&emsp; </label>
                            <div> { this.state.excDC3A1.vb1max }</div>
                        </div>
                        <div className = "row">
                            <label> vblim:&emsp; </label>
                            <div> { this.state.excDC3A1.vblim }</div>
                        </div>
                        <div className = "row">
                            <label> vbmax:&emsp; </label>
                            <div> { this.state.excDC3A1.vbmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excDC3A1.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excDC3A1.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC3A1Component
