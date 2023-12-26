import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService'

class ViewDiscExcContIEEEDEC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discExcContIEEEDEC1A: {}
        }
    }

    componentDidMount(){
        DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1AById(this.state.id).then( res => {
            this.setState({discExcContIEEEDEC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscExcContIEEEDEC1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> esc:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.esc }</div>
                        </div>
                        <div className = "row">
                            <label> kan:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.kan }</div>
                        </div>
                        <div className = "row">
                            <label> ketl:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.ketl }</div>
                        </div>
                        <div className = "row">
                            <label> tan:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.tan }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.td }</div>
                        </div>
                        <div className = "row">
                            <label> tl1:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.tl1 }</div>
                        </div>
                        <div className = "row">
                            <label> tl2:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.tl2 }</div>
                        </div>
                        <div className = "row">
                            <label> tw5:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.tw5 }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.value }</div>
                        </div>
                        <div className = "row">
                            <label> vanmax:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vanmax }</div>
                        </div>
                        <div className = "row">
                            <label> vomax:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vomax }</div>
                        </div>
                        <div className = "row">
                            <label> vomin:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vomin }</div>
                        </div>
                        <div className = "row">
                            <label> vsmax:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vsmax }</div>
                        </div>
                        <div className = "row">
                            <label> vsmin:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vsmin }</div>
                        </div>
                        <div className = "row">
                            <label> vtc:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vtc }</div>
                        </div>
                        <div className = "row">
                            <label> vtlmt:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vtlmt }</div>
                        </div>
                        <div className = "row">
                            <label> vtm:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vtm }</div>
                        </div>
                        <div className = "row">
                            <label> vtn:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC1A.vtn }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscExcContIEEEDEC1AComponent
