import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService'

class ViewExcBBCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excBBC: {}
        }
    }

    componentDidMount(){
        ExcBBCService.getExcBBCById(this.state.id).then( res => {
            this.setState({excBBC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcBBC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excBBC.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excBBC.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.excBBC.k }</div>
                        </div>
                        <div className = "row">
                            <label> switchIt:&emsp; </label>
                            <div> { this.state.excBBC.switchIt }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excBBC.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excBBC.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excBBC.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.excBBC.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excBBC.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excBBC.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xe:&emsp; </label>
                            <div> { this.state.excBBC.xe }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcBBCComponent
