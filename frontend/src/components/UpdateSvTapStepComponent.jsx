import React, { Component } from 'react'
import SvTapStepService from '../services/SvTapStepService';

class UpdateSvTapStepComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                position: ''
        }
        this.updateSvTapStep = this.updateSvTapStep.bind(this);

        this.changepositionHandler = this.changepositionHandler.bind(this);
    }

    componentDidMount(){
        SvTapStepService.getSvTapStepById(this.state.id).then( (res) =>{
            let svTapStep = res.data;
            this.setState({
                position: svTapStep.position
            });
        });
    }

    updateSvTapStep = (e) => {
        e.preventDefault();
        let svTapStep = {
            svTapStepId: this.state.id,
            position: this.state.position
        };
        console.log('svTapStep => ' + JSON.stringify(svTapStep));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvTapStepService.updateSvTapStep(svTapStep).then( res => {
            this.props.history.push('/svTapSteps');
        });
    }

    changepositionHandler= (event) => {
        this.setState({position: event.target.value});
    }

    cancel(){
        this.props.history.push('/svTapSteps');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvTapStep</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> position: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvTapStep}>Save</button>
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

export default UpdateSvTapStepComponent
