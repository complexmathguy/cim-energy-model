import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService'

class ViewExcIEEEAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC5A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC5AService.getExcIEEEAC5AById(this.state.id).then( res => {
            this.setState({excIEEEAC5A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC5A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> tf3:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.tf3 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEAC5A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC5AComponent
