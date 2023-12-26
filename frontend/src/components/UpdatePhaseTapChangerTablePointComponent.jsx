import React, { Component } from 'react'
import PhaseTapChangerTablePointService from '../services/PhaseTapChangerTablePointService';

class UpdatePhaseTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                angle: ''
        }
        this.updatePhaseTapChangerTablePoint = this.updatePhaseTapChangerTablePoint.bind(this);

        this.changeangleHandler = this.changeangleHandler.bind(this);
    }

    componentDidMount(){
        PhaseTapChangerTablePointService.getPhaseTapChangerTablePointById(this.state.id).then( (res) =>{
            let phaseTapChangerTablePoint = res.data;
            this.setState({
                angle: phaseTapChangerTablePoint.angle
            });
        });
    }

    updatePhaseTapChangerTablePoint = (e) => {
        e.preventDefault();
        let phaseTapChangerTablePoint = {
            phaseTapChangerTablePointId: this.state.id,
            angle: this.state.angle
        };
        console.log('phaseTapChangerTablePoint => ' + JSON.stringify(phaseTapChangerTablePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        PhaseTapChangerTablePointService.updatePhaseTapChangerTablePoint(phaseTapChangerTablePoint).then( res => {
            this.props.history.push('/phaseTapChangerTablePoints');
        });
    }

    changeangleHandler= (event) => {
        this.setState({angle: event.target.value});
    }

    cancel(){
        this.props.history.push('/phaseTapChangerTablePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PhaseTapChangerTablePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> angle: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePhaseTapChangerTablePoint}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdatePhaseTapChangerTablePointComponent
