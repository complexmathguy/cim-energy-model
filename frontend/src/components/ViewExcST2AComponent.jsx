import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService'

class ViewExcST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST2A: {}
        }
    }

    componentDidMount(){
        ExcST2AService.getExcST2AById(this.state.id).then( res => {
            this.setState({excST2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST2A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excST2A.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excST2A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excST2A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excST2A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excST2A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excST2A.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excST2A.kp }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excST2A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excST2A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excST2A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excST2A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excST2A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> uelin:&emsp; </label>
                            <div> { this.state.excST2A.uelin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST2A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST2A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST2AComponent
