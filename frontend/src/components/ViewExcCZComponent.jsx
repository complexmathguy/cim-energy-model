import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService'

class ViewExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excCZ: {}
        }
    }

    componentDidMount(){
        ExcCZService.getExcCZById(this.state.id).then( res => {
            this.setState({excCZ: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcCZ Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excCZ.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excCZ.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excCZ.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excCZ.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excCZ.kp }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excCZ.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excCZ.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excCZ.te }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excCZ.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excCZ.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcCZComponent
