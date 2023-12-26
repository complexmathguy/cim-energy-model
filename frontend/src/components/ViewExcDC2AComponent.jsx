import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService'

class ViewExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC2A: {}
        }
    }

    componentDidMount(){
        ExcDC2AService.getExcDC2AById(this.state.id).then( res => {
            this.setState({excDC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC2A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excDC2A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excDC2A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excDC2A.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excDC2A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excDC2A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excDC2A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excDC2A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excDC2A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excDC2A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excDC2A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excDC2A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excDC2A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excDC2A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excDC2A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tf1:&emsp; </label>
                            <div> { this.state.excDC2A.tf1 }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excDC2A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excDC2A.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> vtlim:&emsp; </label>
                            <div> { this.state.excDC2A.vtlim }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC2AComponent
