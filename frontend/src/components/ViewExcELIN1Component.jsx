import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service'

class ViewExcELIN1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excELIN1: {}
        }
    }

    componentDidMount(){
        ExcELIN1Service.getExcELIN1ById(this.state.id).then( res => {
            this.setState({excELIN1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcELIN1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> dpnf:&emsp; </label>
                            <div> { this.state.excELIN1.dpnf }</div>
                        </div>
                        <div className = "row">
                            <label> efmax:&emsp; </label>
                            <div> { this.state.excELIN1.efmax }</div>
                        </div>
                        <div className = "row">
                            <label> efmin:&emsp; </label>
                            <div> { this.state.excELIN1.efmin }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.excELIN1.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> ks2:&emsp; </label>
                            <div> { this.state.excELIN1.ks2 }</div>
                        </div>
                        <div className = "row">
                            <label> smax:&emsp; </label>
                            <div> { this.state.excELIN1.smax }</div>
                        </div>
                        <div className = "row">
                            <label> tfi:&emsp; </label>
                            <div> { this.state.excELIN1.tfi }</div>
                        </div>
                        <div className = "row">
                            <label> tnu:&emsp; </label>
                            <div> { this.state.excELIN1.tnu }</div>
                        </div>
                        <div className = "row">
                            <label> ts1:&emsp; </label>
                            <div> { this.state.excELIN1.ts1 }</div>
                        </div>
                        <div className = "row">
                            <label> ts2:&emsp; </label>
                            <div> { this.state.excELIN1.ts2 }</div>
                        </div>
                        <div className = "row">
                            <label> tsw:&emsp; </label>
                            <div> { this.state.excELIN1.tsw }</div>
                        </div>
                        <div className = "row">
                            <label> vpi:&emsp; </label>
                            <div> { this.state.excELIN1.vpi }</div>
                        </div>
                        <div className = "row">
                            <label> vpnf:&emsp; </label>
                            <div> { this.state.excELIN1.vpnf }</div>
                        </div>
                        <div className = "row">
                            <label> vpu:&emsp; </label>
                            <div> { this.state.excELIN1.vpu }</div>
                        </div>
                        <div className = "row">
                            <label> xe:&emsp; </label>
                            <div> { this.state.excELIN1.xe }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcELIN1Component
