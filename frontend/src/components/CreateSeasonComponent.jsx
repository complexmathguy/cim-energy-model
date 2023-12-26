import React, { Component } from 'react'
import SeasonService from '../services/SeasonService';

class CreateSeasonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                endDate: '',
                startDate: ''
        }
        this.changeendDateHandler = this.changeendDateHandler.bind(this);
        this.changestartDateHandler = this.changestartDateHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SeasonService.getSeasonById(this.state.id).then( (res) =>{
                let season = res.data;
                this.setState({
                    endDate: season.endDate,
                    startDate: season.startDate
                });
            });
        }        
    }
    saveOrUpdateSeason = (e) => {
        e.preventDefault();
        let season = {
                seasonId: this.state.id,
                endDate: this.state.endDate,
                startDate: this.state.startDate
            };
        console.log('season => ' + JSON.stringify(season));

        // step 5
        if(this.state.id === '_add'){
            season.seasonId=''
            SeasonService.createSeason(season).then(res =>{
                this.props.history.push('/seasons');
            });
        }else{
            SeasonService.updateSeason(season).then( res => {
                this.props.history.push('/seasons');
            });
        }
    }
    
    changeendDateHandler= (event) => {
        this.setState({endDate: event.target.value});
    }
    changestartDateHandler= (event) => {
        this.setState({startDate: event.target.value});
    }

    cancel(){
        this.props.history.push('/seasons');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Season</h3>
        }else{
            return <h3 className="text-center">Update Season</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> endDate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> startDate: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSeason}>Save</button>
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

export default CreateSeasonComponent
