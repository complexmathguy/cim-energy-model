import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService'

class ViewExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excOEX3T: {}
        }
    }

    componentDidMount(){
        ExcOEX3TService.getExcOEX3TById(this.state.id).then( res => {
            this.setState({excOEX3T: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcOEX3T Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> e1:&emsp; </label>
                            <div> { this.state.excOEX3T.e1 }</div>
                        </div>
                        <div className = "row">
                            <label> e2:&emsp; </label>
                            <div> { this.state.excOEX3T.e2 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excOEX3T.ka }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excOEX3T.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excOEX3T.kd }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excOEX3T.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excOEX3T.kf }</div>
                        </div>
                        <div className = "row">
                            <label> see1:&emsp; </label>
                            <div> { this.state.excOEX3T.see1 }</div>
                        </div>
                        <div className = "row">
                            <label> see2:&emsp; </label>
                            <div> { this.state.excOEX3T.see2 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excOEX3T.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excOEX3T.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excOEX3T.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.excOEX3T.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.excOEX3T.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.excOEX3T.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excOEX3T.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excOEX3T.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excOEX3T.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excOEX3T.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcOEX3TComponent
