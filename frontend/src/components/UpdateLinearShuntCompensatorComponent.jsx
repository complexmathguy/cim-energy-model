import React, { Component } from 'react'
import LinearShuntCompensatorService from '../services/LinearShuntCompensatorService';

class UpdateLinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b0PerSection: '',
                bPerSection: '',
                g0PerSection: '',
                gPerSection: ''
        }
        this.updateLinearShuntCompensator = this.updateLinearShuntCompensator.bind(this);

        this.changeb0PerSectionHandler = this.changeb0PerSectionHandler.bind(this);
        this.changebPerSectionHandler = this.changebPerSectionHandler.bind(this);
        this.changeg0PerSectionHandler = this.changeg0PerSectionHandler.bind(this);
        this.changegPerSectionHandler = this.changegPerSectionHandler.bind(this);
    }

    componentDidMount(){
        LinearShuntCompensatorService.getLinearShuntCompensatorById(this.state.id).then( (res) =>{
            let linearShuntCompensator = res.data;
            this.setState({
                b0PerSection: linearShuntCompensator.b0PerSection,
                bPerSection: linearShuntCompensator.bPerSection,
                g0PerSection: linearShuntCompensator.g0PerSection,
                gPerSection: linearShuntCompensator.gPerSection
            });
        });
    }

    updateLinearShuntCompensator = (e) => {
        e.preventDefault();
        let linearShuntCompensator = {
            linearShuntCompensatorId: this.state.id,
            b0PerSection: this.state.b0PerSection,
            bPerSection: this.state.bPerSection,
            g0PerSection: this.state.g0PerSection,
            gPerSection: this.state.gPerSection
        };
        console.log('linearShuntCompensator => ' + JSON.stringify(linearShuntCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        LinearShuntCompensatorService.updateLinearShuntCompensator(linearShuntCompensator).then( res => {
            this.props.history.push('/linearShuntCompensators');
        });
    }

    changeb0PerSectionHandler= (event) => {
        this.setState({b0PerSection: event.target.value});
    }
    changebPerSectionHandler= (event) => {
        this.setState({bPerSection: event.target.value});
    }
    changeg0PerSectionHandler= (event) => {
        this.setState({g0PerSection: event.target.value});
    }
    changegPerSectionHandler= (event) => {
        this.setState({gPerSection: event.target.value});
    }

    cancel(){
        this.props.history.push('/linearShuntCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LinearShuntCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b0PerSection: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bPerSection: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0PerSection: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gPerSection: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLinearShuntCompensator}>Save</button>
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

export default UpdateLinearShuntCompensatorComponent
