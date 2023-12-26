import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService';

class UpdateBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                boundaryPoint: '',
                fromEndIsoCode: '',
                fromEndName: '',
                fromEndNameTso: '',
                toEndIsoCode: '',
                toEndName: '',
                toEndNameTso: ''
        }
        this.updateBoundaryExtensions = this.updateBoundaryExtensions.bind(this);

        this.changeboundaryPointHandler = this.changeboundaryPointHandler.bind(this);
        this.changefromEndIsoCodeHandler = this.changefromEndIsoCodeHandler.bind(this);
        this.changefromEndNameHandler = this.changefromEndNameHandler.bind(this);
        this.changefromEndNameTsoHandler = this.changefromEndNameTsoHandler.bind(this);
        this.changetoEndIsoCodeHandler = this.changetoEndIsoCodeHandler.bind(this);
        this.changetoEndNameHandler = this.changetoEndNameHandler.bind(this);
        this.changetoEndNameTsoHandler = this.changetoEndNameTsoHandler.bind(this);
    }

    componentDidMount(){
        BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( (res) =>{
            let boundaryExtensions = res.data;
            this.setState({
                boundaryPoint: boundaryExtensions.boundaryPoint,
                fromEndIsoCode: boundaryExtensions.fromEndIsoCode,
                fromEndName: boundaryExtensions.fromEndName,
                fromEndNameTso: boundaryExtensions.fromEndNameTso,
                toEndIsoCode: boundaryExtensions.toEndIsoCode,
                toEndName: boundaryExtensions.toEndName,
                toEndNameTso: boundaryExtensions.toEndNameTso
            });
        });
    }

    updateBoundaryExtensions = (e) => {
        e.preventDefault();
        let boundaryExtensions = {
            boundaryExtensionsId: this.state.id,
            boundaryPoint: this.state.boundaryPoint,
            fromEndIsoCode: this.state.fromEndIsoCode,
            fromEndName: this.state.fromEndName,
            fromEndNameTso: this.state.fromEndNameTso,
            toEndIsoCode: this.state.toEndIsoCode,
            toEndName: this.state.toEndName,
            toEndNameTso: this.state.toEndNameTso
        };
        console.log('boundaryExtensions => ' + JSON.stringify(boundaryExtensions));
        console.log('id => ' + JSON.stringify(this.state.id));
        BoundaryExtensionsService.updateBoundaryExtensions(boundaryExtensions).then( res => {
            this.props.history.push('/boundaryExtensionss');
        });
    }

    changeboundaryPointHandler= (event) => {
        this.setState({boundaryPoint: event.target.value});
    }
    changefromEndIsoCodeHandler= (event) => {
        this.setState({fromEndIsoCode: event.target.value});
    }
    changefromEndNameHandler= (event) => {
        this.setState({fromEndName: event.target.value});
    }
    changefromEndNameTsoHandler= (event) => {
        this.setState({fromEndNameTso: event.target.value});
    }
    changetoEndIsoCodeHandler= (event) => {
        this.setState({toEndIsoCode: event.target.value});
    }
    changetoEndNameHandler= (event) => {
        this.setState({toEndName: event.target.value});
    }
    changetoEndNameTsoHandler= (event) => {
        this.setState({toEndNameTso: event.target.value});
    }

    cancel(){
        this.props.history.push('/boundaryExtensionss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BoundaryExtensions</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> boundaryPoint: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndIsoCode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndName: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fromEndNameTso: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndIsoCode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndName: </label>
                                            #formFields( $attribute, 'update')
                                            <label> toEndNameTso: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBoundaryExtensions}>Save</button>
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

export default UpdateBoundaryExtensionsComponent
