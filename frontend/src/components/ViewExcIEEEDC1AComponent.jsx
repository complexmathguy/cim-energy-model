import React, { Component } from 'react'
import ExcIEEEDC1AService from '../services/ExcIEEEDC1AService'

class ViewExcIEEEDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC1AService.getExcIEEEDC1AById(this.state.id).then( res => {
            this.setState({excIEEEDC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> exclim:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.exclim }</div>
                        </div>
                        <div className = "row">
                            <label> ka:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.ka }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.ke }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.kf }</div>
                        </div>
                        <div className = "row">
                            <label> seefd1:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.seefd1 }</div>
                        </div>
                        <div className = "row">
                            <label> seefd2:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.seefd2 }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.ta }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.te }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.tf }</div>
                        </div>
                        <div className = "row">
                            <label> uelin:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.uelin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excIEEEDC1A.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC1AComponent
