import React, { Component } from 'react'
import ExcST3AService from '../services/ExcST3AService'

class ViewExcST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST3A: {}
        }
    }

    componentDidMount(){
        ExcST3AService.getExcST3AById(this.state.id).then( res => {
            this.setState({excST3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST3A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excST3A.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excST3A.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.excST3A.kg }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excST3A.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kj:&emsp; </label>
                            <div> { this.state.excST3A.kj }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.excST3A.km }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excST3A.kp }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.excST3A.ks }</div>
                        </div>
                        <div className = "row">
                            <label> ks1:&emsp; </label>
                            <div> { this.state.excST3A.ks1 }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excST3A.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excST3A.tc }</div>
                        </div>
                        <div className = "row">
                            <label> thetap:&emsp; </label>
                            <div> { this.state.excST3A.thetap }</div>
                        </div>
                        <div className = "row">
                            <label> tm:&emsp; </label>
                            <div> { this.state.excST3A.tm }</div>
                        </div>
                        <div className = "row">
                            <label> vbmax:&emsp; </label>
                            <div> { this.state.excST3A.vbmax }</div>
                        </div>
                        <div className = "row">
                            <label> vgmax:&emsp; </label>
                            <div> { this.state.excST3A.vgmax }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excST3A.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excST3A.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST3A.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST3A.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xl:&emsp; </label>
                            <div> { this.state.excST3A.xl }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST3AComponent
