import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService'

class ViewExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC1A: {}
        }
    }

    componentDidMount(){
        ExcDC1AService.getExcDC1AById(this.state.id).then( res => {
            this.setState({excDC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> edfmax:&emsp; </label>
                            <div> { this.state.excDC1A.edfmax }</div>
                        </div>
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excDC1A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excDC1A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excDC1A.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excDC1A.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excDC1A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excDC1A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excDC1A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excDC1A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excDC1A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excDC1A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excDC1A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excDC1A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excDC1A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excDC1A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excDC1A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excDC1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excDC1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC1AComponent
